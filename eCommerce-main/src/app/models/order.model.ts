import { OrderDetail } from "./orderDetail.model";

export interface Order {
    orderId: number,
    orderDetailList: OrderDetail[],
    totalPrice: number,
    dateOrder: Date,
    deliveryDate: Date,
    status: string,
    tax: number,
    quantity: number,
    isAccept: boolean
}