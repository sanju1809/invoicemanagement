import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceManager {
    private List<Invoice> invoices = new ArrayList<>();
    private int nextId = 1;

    // Create
    public Invoice createInvoice(String description, double amount) {
        Invoice invoice = new Invoice(nextId++, description, amount);
        invoices.add(invoice);
        return invoice;
    }

    // Read
    public List<Invoice> getAllInvoices() {
        return invoices;
    }

    public Invoice getInvoiceById(int id) {
        Optional<Invoice> invoice = invoices.stream().filter(inv -> inv.getId() == id).findFirst();
        return invoice.orElse(null);
    }

    // Update
    public boolean updateInvoice(int id, String description, double amount) {
        Invoice invoice = getInvoiceById(id);
        if (invoice != null) {
            invoice.setDescription(description);
            invoice.setAmount(amount);
            return true;
        }
        return false;
    }

    // Delete
    public boolean deleteInvoice(int id) {
        return invoices.removeIf(inv -> inv.getId() == id);
    }
}
