Class: Order
Responsibilities:
- Store order data (customer, item, price)
Collaborators:
- TaxCalculator, DiscountService

Class: TaxCalculator
Responsibilities:
- Calculate tax for an order
Collaborators:
- Order

Class: DiscountService
Responsibilities:
- Apply discounts based on rules
Collaborators:
- Order

Class: ReceiptPrinter
Responsibilities:
- Print order details
Collaborators:
- Order

Class: OrderRepository
Responsibilities:
- Save orders to storage
Collaborators:
- Order

Class: EmailService
Responsibilities:
- Send confirmation emails
Collaborators:
- Order

Class: LoggerService
Responsibilities:
- Log system activity
Collaborators:
- Order