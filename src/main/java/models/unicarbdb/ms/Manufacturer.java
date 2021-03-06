/*
 * Copyright (c) 2014. Copyright (c) 2014. Matthew Campbell <matthew.campbell@mq.edu.au>
 *
 * The program can not be distributed to others with out the consent of the copyright holder, until such a time that the copyright holder has released the code for public use.
 */

package models.unicarbdb.ms;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="ms", name="manufacturer")
public class Manufacturer  {
	
	@Id
    @Column(name = "manufacturer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturer_gen")
    @SequenceGenerator(name = "manufacturer_gen", sequenceName = "ms.manufacturer_manufacturer_id_seq", allocationSize=1)
	//public Long Id;
	public Long manufacturerId;
     
   public String name;
     
   public String url;

   @OneToMany(mappedBy = "manufacturer")
   public List<Device> devices; // = new HashSet<Device>(0);

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
