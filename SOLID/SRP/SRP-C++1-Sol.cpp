#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Order
{
private:
    vector<string> items;
    vector<int> quantities;
    vector<double> prices;
    string status;

public:
    Order() : status("open") {}

    void addItem(const string &name, int quantity, double price)
    {
        items.push_back(name);
        quantities.push_back(quantity);
        prices.push_back(price);
    }

    double totalPrice() const
    {
        double total = 0;
        for (size_t i = 0; i < prices.size(); ++i)
        {
            total += quantities[i] * prices[i];
        }
        return total;
    }

    void setStatus(const string &newStatus)
    {
        status = newStatus;
    }

    const string &getStatus() const
    {
        return status;
    }
};


// Abstract class (interface) for PaymentProcessor
class PaymentProcessor {
public:
    virtual void pay(Order& order, const string& securityCode) = 0;
    virtual ~PaymentProcessor() = default;
};

// Concrete class for DebitPaymentProcessor
class DebitPaymentProcessor : public PaymentProcessor {
public:
    void pay(Order& order, const string& securityCode) override {
        cout << "Processing debit payment type\n";
        cout << "Verifying security code: " << securityCode << "\n";
        order.setStatus("paid");
    }
};

// Concrete class for CreditPaymentProcessor
class CreditPaymentProcessor : public PaymentProcessor {
public:
    void pay(Order& order, const string& securityCode) override {
        cout << "Processing credit payment type\n";
        cout << "Verifying security code: " << securityCode << "\n";
        order.setStatus("paid");
    }
};

// Concrete class for UPIPaymentProcessor
class UPIPaymentProcessor : public PaymentProcessor {
public:
    void pay(Order& order, const string& securityCode) override {
        cout << "Processing UPI payment type\n";
        cout << "Verifying security code: " << securityCode << "\n";
        order.setStatus("paid");
    }
};

/* class PaymentProcessor
{
public:
    void pay(Order &order, const string &securityCode, string paymentType)
    {
        if (paymentType == "debit")
        {
            cout << "Processing debit payment type" << endl;
            cout << "Verifying security code: " << securityCode << endl;
            order.setStatus("paid");
        }
        else if (paymentType == "credit")
        {
            cout << "Processing credit payment type" << endl;
            cout << "Verifying security code: " << securityCode << endl;
            order.setStatus("paid");
        }
    }
}; */

int main()
{
    Order order;
    order.addItem("Keyboard", 1, 50);
    order.addItem("SSD", 1, 150);
    order.addItem("USB cable", 2, 5);

    cout << order.totalPrice() << endl;

    // PaymentProcessor processor;
    // processor.pay(order, "0372846", "debit");

    PaymentProcessor* processor = new DebitPaymentProcessor();
    processor->pay(order, "y3743y7");

    cout << "Order status: " << order.getStatus() << "\n";

    // Clean up
    delete processor;

    return 0;
}