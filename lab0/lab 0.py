from abc import ABC, abstractmethod


class MenuItem:
    def __init__(self, name, price, category):
        self.name = name
        self.price = price
        self.category = category

    def __str__(self):
        return f"{self.name} ({self.category}): ${self.price:.2f}"


class Menu:
    def __init__(self):
        self.items = []

    def add_item(self, item: MenuItem):
        self.items.append(item)

    def remove_item(self, item_name: str):
        self.items = [item for item in self.items if item.name != item_name]

    def display_menu(self):
        print("\n--- Restaurant Menu ---")
        for item in self.items:
            print(item)


class Order:
    def __init__(self):
        self.ordered_items = []

    def add_to_order(self, item: MenuItem):
        self.ordered_items.append(item)
        print(f"Added {item.name} to the order.")

    def calculate_total(self):
        return sum(item.price for item in self.ordered_items)

    def display_order(self):
        print("\n--- Your Order ---")
        for item in self.ordered_items:
            print(item)
        print(f"Total: ${self.calculate_total():.2f}")


class PaymentProcessor(ABC):
    @abstractmethod
    def process_payment(self, amount):
        pass


class CashPaymentProcessor(PaymentProcessor):
    def process_payment(self, amount):
        print(f"Processing cash payment of ${amount:.2f}...")


class CardPaymentProcessor(PaymentProcessor):
    def process_payment(self, amount):
        print(f"Processing card payment of ${amount:.2f}...")
        card_number = input("Enter your card number: ")
        print(f"Verifying card number: {card_number}...")


if __name__ == "__main__":
    menu = Menu()
    menu.add_item(MenuItem("Burger", 8.00, "Main Course"))
    menu.add_item(MenuItem("Fries", 3.00, "Side"))
    menu.add_item(MenuItem("Coke", 1.50, "Drink"))
    menu.add_item(MenuItem("Ice Cream", 4.00, "Dessert"))

    menu.display_menu()

    order = Order()
    order.add_to_order(MenuItem("Burger", 8.00, "Main Course"))
    order.add_to_order(MenuItem("Coke", 1.50, "Drink"))

    order.display_order()

    payment_method = input("\nEnter payment method (cash/card): ").lower()
    if payment_method == "cash":
        processor = CashPaymentProcessor()
    elif payment_method == "card":
        processor = CardPaymentProcessor()
    else:
        print("Invalid payment method. Please enter 'cash' or 'card'.")
        processor = None

    if processor:
        processor.process_payment(order.calculate_total())
