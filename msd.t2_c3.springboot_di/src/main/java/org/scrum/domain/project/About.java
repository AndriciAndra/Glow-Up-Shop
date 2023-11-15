package org.scrum.domain.project;


import java.util.List;

public class About {
    private int id;

    private String salonDescription;

    private String servicesOffered;

    private String servicesDescription;

    private List<String> customerFeedback;

    private List<String> employeePhotos;

    public About() {
    }

    public About(String salonDescription,
                   String servicesOffered,
                   String servicesDescription,
                   List<String> customerFeedback,
                   List<String> employeePhotos) {
        this.salonDescription = salonDescription;
        this.servicesOffered = servicesOffered;
        this.servicesDescription = servicesDescription;
        this.customerFeedback = customerFeedback;
        this.employeePhotos = employeePhotos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalonDescription() {
        return salonDescription;
    }

    public void setSalonDescription(String salonDescription) {
        this.salonDescription = salonDescription;
    }

    public String getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(String servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    public String getServicesDescription() {
        return servicesDescription;
    }

    public void setServicesDescription(String servicesDescription) {
        this.servicesDescription = servicesDescription;
    }

    public List<String> getCustomerFeedback() {
        return customerFeedback;
    }

    public void setCustomerFeedback(List<String> customerFeedback) {
        this.customerFeedback = customerFeedback;
    }

    public List<String> getEmployeePhotos() {
        return employeePhotos;
    }

    public void setEmployeePhotos(List<String> employeePhotos) {
        this.employeePhotos = employeePhotos;
    }
}
