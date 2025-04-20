package pet.project.Messenger.dto.order;

import lombok.Data;

@Data
public class OrderItemCreateDto {
	private Long productId;
	private Integer quantity;
}
