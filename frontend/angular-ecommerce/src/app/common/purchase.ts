import { OrderItem } from './order-item';
import { Order } from './order';
import { Address } from './address';
import { Customer } from './customer';
export class Purchase {
  cusomter: Customer;
  shippingAddress: Address;
  billingAddress: Address;
  order: Order;
  orderItem: OrderItem[];
}
