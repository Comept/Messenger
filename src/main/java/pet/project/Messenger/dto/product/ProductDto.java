package pet.project.Messenger.dto.product;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductDto {
	private Long id;
	private String name;
	private String description;
	private Integer price;
	private Integer stock;
	private Integer reservedQuantity;
	private Long categoryId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
