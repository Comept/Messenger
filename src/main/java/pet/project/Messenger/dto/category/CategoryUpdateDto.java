package pet.project.Messenger.dto.category;

import lombok.Data;

@Data
public class CategoryUpdateDto {
	private String name;
	private String description;
	private Long parentCategoryId;
}
