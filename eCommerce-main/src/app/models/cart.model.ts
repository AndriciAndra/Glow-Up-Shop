import { CartItem } from "./cartItem.model";

export interface Cart {
    id: number,
    client: string,
    totalPrice: number,
    totalItems: number,
    cartItems: CartItem[]
}