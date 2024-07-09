package com.example.Product;
public class Mobile {
    private Long id;
    private String name;
    private String model;
    private String os_version;
    private String storage;
    private Long price;


    public Mobile() {}
    public Mobile(Long id,String name,String model,String os_version,String storage,Long price){
        this.id=id;
        this.name=name;
        this.model=model;
        this.os_version=os_version;
        this.storage=storage;
        this.price=price;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStorage() {
        return storage;
    }



    public void setStorage(String storage) {
        this.storage = storage;
    }
    @Override
    public String toString(){
        return "Mobile{" + "id=" + id + ",name=" + name +",model=" + model + ",os_version=" + os_version + ",storage=" + storage + ",price=" + price  +'\'' + '}';
    }

}
