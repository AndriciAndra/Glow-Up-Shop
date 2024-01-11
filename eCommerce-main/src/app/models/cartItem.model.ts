import { Cart } from "./cart.model";
import { Item } from "./item.model";

export interface CartItem {
    id: number,
    cart: Cart,
    item: Item,
    quantity: number,
    price: number
}