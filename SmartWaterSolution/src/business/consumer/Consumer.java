/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.consumer;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author vinay
 */
public class Consumer {
    
    
    private StorageTank storageTank;
    private WaterOutlets waterOutlets;
    private String address;
    private PumpConfiguration pumpConfiguration;
    private Map<Date,String> trackWaterUsageMap;
    
    private ArrayList<StorageTank> storageTanks;

    public ArrayList<StorageTank> getStorageTanks() {
        return storageTanks;
    }

    public void setStorageTanks(ArrayList<StorageTank> storageTanks) {
        this.storageTanks = storageTanks;
    }
    
    
    
    public Consumer(){
    storageTank = new StorageTank();
    waterOutlets = new WaterOutlets();
    this.pumpConfiguration = new PumpConfiguration();
    this.trackWaterUsageMap = new HashMap<Date,String>();
    
    }

    public PumpConfiguration getPumpConfiguration() {
        return pumpConfiguration;
    }

    public void setPumpConfiguration(PumpConfiguration pumpConfiguration) {
        this.pumpConfiguration = pumpConfiguration;
    }
    
    
    public StorageTank getStorageTank() {
        return storageTank;
    }

    public void setStorageTank(StorageTank storageTank) {
        this.storageTank = storageTank;
    }

    public WaterOutlets getWaterOutlets() {
        return waterOutlets;
    }

    public void setWaterOutlets(WaterOutlets waterOutlets) {
        this.waterOutlets = waterOutlets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Date, String> getTrackWaterUsageMap() {
        return trackWaterUsageMap;
    }
   
    public void addIntoTrackWaterUsageMap(String waterOutletName,double usage){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String convertUsageToString=Double.toString(usage);
        String finalInput = waterOutletName+','+convertUsageToString;
        trackWaterUsageMap.put(date, finalInput);
        
        }
    
    public void initStorageTanks(double capacity,String dimensions,int size)
   {
        storageTanks = new ArrayList<StorageTank>(size);
        for(int i=0;i<size;i++)
        {
           StorageTank s= new StorageTank();
           s.setCapacity(capacity);
           s.setDimensions(dimensions);
           s.setTotalCapacity(capacity);
           storageTanks.add(s);   
        }
       
   }
}
