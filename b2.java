interface Refundable {
    void refund();
}

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract void pay();

    public void printAmount() {
        System.out.println("Số tiền giao dịch: " + amount);
    }
}

class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Đang thực hiện thanh toán bằng Tiền mặt...");
    }
}

class CreditCardPayment extends Payment implements Refundable {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Đang kết nối cổng thanh toán thẻ Credit Card...");
    }

    @Override
    public void refund() {
        System.out.println("-> Đã hoàn tiền vào thẻ Credit Card cho khách hàng.");
    }
}

class EWalletPayment extends Payment implements Refundable {
    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Đang thực hiện thanh toán qua Ví điện tử (E-Wallet)...");
    }

    @Override
    public void refund() {
        System.out.println("-> Đã hoàn tiền về số dư Ví điện tử.");
    }
}

public class b2 {
    public static void main(String[] args) {
        Payment[] payments = {
                new CashPayment(500.0),
                new CreditCardPayment(1200.0),
                new EWalletPayment(350.0)
        };

        System.out.println("===== HỆ THỐNG XỬ LÝ THANH TOÁN =====");

        for (Payment p : payments) {
            p.printAmount();
            p.pay();

            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            } else {
                System.out.println("x Hình thức này không hỗ trợ hoàn tiền trực tuyến.");
            }
            System.out.println("-------------------------------------");
        }
    }
}