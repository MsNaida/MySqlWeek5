package entity;


public class Order {
		
		private int orderId;
		private String name;
		private String flavor;
		private int scoops;
			
		public Order (int orderId, String name, String flavor, int scoops) { 
			this.setOrderId(orderId);
			this.setName(name);
			this.setFlavor(flavor);
			this.setScoops(scoops);
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFlavor() {
			return flavor;
		}

		public void setFlavor(String flavor) {
			this.flavor = flavor;
		}

		public int getScoops() {
			return scoops;
		}

		public void setScoops(int scoops) {
			this.scoops = scoops;
		}

	}


