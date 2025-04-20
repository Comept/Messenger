package pet.project.Messenger.dto.order;

import lombok.Data;

import java.util.Set;

@Data
public class OrderCreateDto {
	private Long userId;
	private Set<OrderItemCreateDto> items;
}
