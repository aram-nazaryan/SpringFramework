package com.sourcemind.management.facade;

import java.util.List;

public record ProductParams(String name, String description, List<String> tagList, String ownerName) {
}
