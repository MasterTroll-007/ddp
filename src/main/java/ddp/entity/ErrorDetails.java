package ddp.entity;

import java.util.List;

public record ErrorDetails(String message, List<String> errors) {
}