package pet.project.Messenger.dto.order;

import lombok.Data;
import pet.project.Messenger.model.OrderStatus;

@Data
public class OrderUpdateDto {
	private OrderStatus status;
}
