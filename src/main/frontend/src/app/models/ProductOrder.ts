import { Books } from './Books';

export class ProductOrder {
    books: Books;
    quantity: number;
 
    constructor(books:  Books, quantity : number) {
        this.books = books;
        this.quantity = quantity;
    }
}