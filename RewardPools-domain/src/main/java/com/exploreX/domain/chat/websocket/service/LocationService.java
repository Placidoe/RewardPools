package com.exploreX.domain.chat.websocket.service;

import com.exploreX.domain.chat.websocket.entity.Location;
import org.springframework.stereotype.Service;

/**
 * @author lei
 * @create 2023-05-05 11:36
 * @desc
 **/
@Service
public class LocationService {


    public Location getLastLocationByUser(String userId) {
        return new Location(userId, 104444, 30441);
    }
}
