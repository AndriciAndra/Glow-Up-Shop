export interface Item {
    id: number,
    productName: string,
    description: string,
    costPrice: number,
    salePrice: number,
    category: string,
    photo: string,
    currentQuantity: number,
    isActivated: boolean,
    isDeleted: boolean
}