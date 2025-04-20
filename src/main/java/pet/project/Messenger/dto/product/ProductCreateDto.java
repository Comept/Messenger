package pet.project.Messenger.dto.product;

import lombok.Data;

@Data
public class ProductCreateDto {
	private String name;
	private String description;
	private Integer price;
	private Integer stock;
	private Long categoryId;
}
