package pet.project.Messenger.dto.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderItemDto {
	private Long id;
	private Long orderId;
	private Long productId;
	private Integer quantity;
	private Integer price;
	private LocalDateTime createdAt;
}
