package s14.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import s14.Main;

public class MainRegion {
	private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        RegionDao rd = new RegionDao();

        // create a new region
        Region anta = new Region(6, "Antartide");
        rd.save(anta);

        // get a region
        Optional<Region> opt = rd.get(6);
        if (opt.isPresent()) {
            System.out.println("Region 501: " + opt.get());

            Region region = opt.get();
            region.setName(region.getName() + " nice");
            rd.update(region);
        } else {
            logger.error("Unexpected! Can't get region 6");
        }

        // rename a region
        anta.setName("Oceania");
        rd.update(anta);

        opt = rd.get(6);
        if (opt.isPresent()) {
            System.out.println("Region 6: " + opt.get());
        } else {
            logger.error("Unexpected! Can't get region 6");
        }

        // delete a region
        rd.delete(6);

        opt = rd.get(6);
        if (opt.isPresent()) {
            logger.error("Unexpected! Region 6 still alive: " + opt.get());
        } else {
            System.out.println("Region 6 is no more");
        }

        // get all regions
        List<Region> regions = rd.getAll();
        System.out.println("Regions: " + regions);
    }
}
