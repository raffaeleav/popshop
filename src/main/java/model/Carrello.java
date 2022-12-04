package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<CapoBean> listaCapi;
    private List<AccessorioBean> listaAccessori;
    private List<FootwearBean> listaFootwear;
    private double totalPrice;

    public Carrello(){
        listaCapi = new ArrayList<>();
        listaFootwear = new ArrayList<>();
        listaAccessori = new ArrayList<>();
        totalPrice = 0;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

    public void setTotalPrice(double newPrice){
        this.totalPrice = newPrice;
    }

    public void addCapo(CapoBean capoBean){
        listaCapi.add(capoBean);
        totalPrice += capoBean.getPrice();
    }

    public void addFoot(FootwearBean footwearBean){
        listaFootwear.add(footwearBean);
        totalPrice += footwearBean.getPrice();
    }

    public void addAcc(AccessorioBean accessorioBean){
        listaAccessori.add(accessorioBean);
        totalPrice += accessorioBean.getPrice();
    }

    public List<CapoBean> getListaCapi(){
        return listaCapi;
    }

    public List<FootwearBean> getListaFootwear(){
        return listaFootwear;
    }

    public List<AccessorioBean> getListaAccessori(){
        return listaAccessori;
    }

}
