public class Main {
    public static void main(String[] args) {
        InvoiceManager manager = new InvoiceManager();

        // Create
        Invoice invoice1 = manager.createInvoice("Office Supplies", 150.75);
        Invoice invoice2 = manager.createInvoice("Consulting Services", 1200.00);

        // Read
        System.out.println("All Invoices:");
        manager.getAllInvoices().forEach(System.out::println);

        // Update
        manager.updateInvoice(invoice1.getId(), "Office Supplies - Updated", 175.00);

        // Read after update
        System.out.println("\nInvoice after update:");
        System.out.println(manager.getInvoiceById(invoice1.getId()));

        // Delete
        manager.deleteInvoice(invoice2.getId());

        // Read after delete
        System.out.println("\nAll Invoices after deletion:");
        manager.getAllInvoices().forEach(System.out::println);
    }
}
