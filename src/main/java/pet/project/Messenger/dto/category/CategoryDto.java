package pet.project.Messenger.dto.category;

import lombok.Data;

@Data
public class CategoryDto {
	private Long id;
	private String name;
	private String description;
	private Long parentCategoryId;
}
