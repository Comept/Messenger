package pet.project.Messenger.dto.order;

import lombok.Data;
import pet.project.Messenger.model.OrderStatus;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class OrderDto {
	private Long id;
	private Long userId;
	private OrderStatus status;
	private Integer totalAmount;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private Set<OrderItemDto> items;
}
