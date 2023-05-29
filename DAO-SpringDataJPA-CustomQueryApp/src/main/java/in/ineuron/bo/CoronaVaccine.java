package in.ineuron.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoronaVaccine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regNo;
	private String name;
	private String company;
	private String country;
	private Double price;
	private Integer rerquiredDoseCount;
	
	public CoronaVaccine() {
		System.out.println("Hibernate Internally uses ZERO_PARAM Constructor during select query");
	}

	public CoronaVaccine(Long regNo, String name, String company, String country, Double price,
			Integer rerquiredDoseCount) {
		super();
		this.regNo = regNo;
		this.name = name;
		this.company = company;
		this.country = country;
		this.price = price;
		this.rerquiredDoseCount = rerquiredDoseCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getRegNo() {
		return regNo;
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public String getCountry() {
		return country;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getRerquiredDoseCount() {
		return rerquiredDoseCount;
	}
	
	

	public void setRegNo(Long regNo) {
		this.regNo = regNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setRerquiredDoseCount(Integer rerquiredDoseCount) {
		this.rerquiredDoseCount = rerquiredDoseCount;
	}

	@Override
	public String toString() {
		return "CoronaVaccine [regNo=" + regNo + ", name=" + name + ", company=" + company + ", country=" + country
				+ ", price=" + price + ", rerquiredDoseCount=" + rerquiredDoseCount + "]";
	}
	
	
	
}
