import { Item } from "./item.model";

export interface OrderDetail {
    id: number,
    totalQuantity: number,
    totalPrice: number,
    item: Item
}