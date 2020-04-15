package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
//         String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("194.62.107.16");
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("194.62.107.16");
        System.out.printf(ipLocation);
    }

}
