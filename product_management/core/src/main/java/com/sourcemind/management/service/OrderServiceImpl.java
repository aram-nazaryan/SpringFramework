package com.sourcemind.management.service;

import com.sourcemind.management.domain.Product;
import com.sourcemind.management.domain.Tag;
import com.sourcemind.management.facade.ProductParams;
import com.sourcemind.management.repository.OrderRepository;
import com.sourcemind.management.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;

    private final TagRepository tagRepository;

    public OrderServiceImpl(OrderRepository orderRepository, TagRepository tagRepository) {
        this.orderRepository = orderRepository;
        this.tagRepository = tagRepository;
    }

    @Override
    public void save(ProductParams params) {
        log.info("OrderServiceImpl save - {}", params);
        Product product = new Product();
        product.setName(params.name());
        product.setDescription(params.description());
        product.setUsername(params.ownerName());
        List<String> strings = params.tagList();
        List<Tag> collect = strings.stream()
                .map(s -> {
                    Tag tag = new Tag(s);
                    tag.setProduct(product);
                    tagRepository.save(tag);
                    return tag;
                }).toList();
        product.setTagList(collect);
    }

    @Override
    public Boolean findProductByImageBlobId(String uuid) {
        log.info("findProductByImageBlobId - {}", uuid);
        Optional<Product> productByImageBlobId = orderRepository.findProductByImageBlobId(uuid);
        return productByImageBlobId.isPresent();
    }

    @Override
    public Optional<Product> findProductByUuid(String uuid) {
        log.info("findProductByUuid - {}", uuid);
        return orderRepository.findProductByImageBlobId(uuid);
    }

    @Override
    public void deleteProduct(Product product) {
        log.info("deleteProduct - {}", product);
        orderRepository.delete(product);
    }

    @Override
    public List<Product> getAll(String username) {
        return orderRepository.findAllByUsername(username);
    }
}
