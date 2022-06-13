import { CartService } from './../../services/cart.service';
import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/common/cart-item';

@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css'],
})
export class CartDetailsComponent implements OnInit {
  cartItems: CartItem[] = [];
  totalPrice: number = 0;
  totalQuantity: number = 0;

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.listCartDetails();
  }

  listCartDetails() {
    //get a hanlde to the cart items
    this.cartItems = this.cartService.cartItems;
    //subscribe to the cart totalPrice
    this.cartService.totalPrice.subscribe((data) => (this.totalPrice = data));
    //subscribe to the cart totalquantity
    this.cartService.totalQuantity.subscribe(
      (data) => (this.totalQuantity = data)
    );
    //compute cart total price and quantity
    //can be delete now, since we are using behaviorSubject ???
    //this.cartService.computeCartTotals();
  }

  incrementQuantity(theCartItem: CartItem) {
    this.cartService.addToCart(theCartItem);
  }

  decrementQuantity(theCartItem: CartItem) {
    this.cartService.decrementQuantity(theCartItem);
  }

  remove(theCartItem: CartItem) {
    this.cartService.remove(theCartItem);
  }
}
