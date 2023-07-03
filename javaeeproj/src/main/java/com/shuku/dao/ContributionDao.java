package com.shuku.dao;


import com.shuku.entity.Contribution;
import org.springframework.stereotype.Repository;


@Repository
public interface ContributionDao {

    public Contribution queryByValue(int value);
}
