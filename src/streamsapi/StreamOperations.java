package streamsapi;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamOperations {
	
	    public static void main(String args[]) {	
	    	
	    	List<Orders> orders = Arrays.asList(
	    			                            new Orders("A271", LocalDate.now(), OrderStatus.PENDING, OrderPaymentStatus.PENDING, 1200),
	    			                            new Orders("BS1", LocalDate.now(), OrderStatus.PENDING, OrderPaymentStatus.PENDING, 600),
	    			                            new Orders("A272", LocalDate.now(), OrderStatus.DELIVERED, OrderPaymentStatus.PAID, 2500),
	    			                            new Orders("C271", LocalDate.now(), OrderStatus.SHIPPED, OrderPaymentStatus.PAID, 1200),
	    			                            new Orders("B271", LocalDate.now(), OrderStatus.PENDING, OrderPaymentStatus.PENDING, 900),
	    			                            new Orders("A272", LocalDate.now(), OrderStatus.PENDING, OrderPaymentStatus.PENDING, 1200),
	    			                            new Orders("BS2", LocalDate.now(), OrderStatus.PENDING, OrderPaymentStatus.PENDING, 600),
	    			                            new Orders("A273", LocalDate.now(), OrderStatus.DELIVERED, OrderPaymentStatus.PAID, 2500),
	    			                            new Orders("C273", LocalDate.now(), OrderStatus.SHIPPED, OrderPaymentStatus.PAID, 1200),
	    			                            new Orders("B275", LocalDate.now(), OrderStatus.PENDING, OrderPaymentStatus.PENDING, 900)
	    			                            );	
//	    	long count  = orders.stream().filter(order -> order.getOrderAmount() > 1500).count();
//	    	System.out.println(count);
//	    	
//	    	System.out.println(orders.stream().filter(order -> order.getOrderAmount() < 1000).findAny().get().getOrderAmount());
	    	
//			boolean orderAmountGreaterThan500 = orders.stream().allMatch(order -> order.getOrderAmount() > 500);
//			System.out.println(orderAmountGreaterThan500);
//			
//			boolean anyOrderAmountGreaterThan2500 = orders.stream().anyMatch(order -> (order.getOrderAmount() > 25000) || (order.getOrderAmount() > 2500));
//			System.out.println(anyOrderAmountGreaterThan2500);
	    	
//	    	orders.stream().limit((int) orders.size() / 2).filter(order -> order.getOrderStatus().equals(OrderStatus.PENDING)).forEach(order -> {
//	    		System.out.println(order.getOrderNumber() + " " + order.getOrderStatus());
//	    	});
	    	
	    	Optional<Orders> max = orders.stream().max(Comparator.comparing(Orders::getOrderAmount));
	    	System.out.println(max.get().getOrderNumber());
	    	
	    }

}










class Orders{
	
	  private String orderNumber;
	  private LocalDate orderDate;
	  private LocalDate shipmentDate;
	  private OrderStatus orderStatus;
	  private OrderPaymentStatus orderPaymentStatus;
	  private double orderAmount;
	public Orders(String orderNumber, LocalDate orderDate,OrderStatus orderStatus,
			OrderPaymentStatus orderPaymentStatus, double orderAmount) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.shipmentDate = shipmentDate;
		this.orderStatus = orderStatus;
		this.orderPaymentStatus = orderPaymentStatus;
		this.orderAmount = orderAmount;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getShipmentDate() {
		return shipmentDate;
	}
	public void setShipmentDate(LocalDate shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public OrderPaymentStatus getOrderPaymentStatus() {
		return orderPaymentStatus;
	}
	public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
		this.orderPaymentStatus = orderPaymentStatus;
	}
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	
	  
} 

enum OrderStatus{
	
	  PENDING,
	  SHIPPED,
	  DELIVERED
}

enum OrderPaymentStatus{
	
	  PENDING,
	  PAID
}