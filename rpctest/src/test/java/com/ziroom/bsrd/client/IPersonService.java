package com.ziroom.bsrd.client;

import java.util.List;

/**
 * Created by luxiaoxun on 2016-03-10.
 */
public interface IPersonService {
    List<Person> GetTestPerson(String name, int num);
}