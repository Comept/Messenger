package pet.project.Messenger.dto.product;

import lombok.Data;

@Data
public class ProductUpdateDto {
	private String name;
	private String description;
	private Integer price;
	private Integer stock;
	private Long categoryId;
}
