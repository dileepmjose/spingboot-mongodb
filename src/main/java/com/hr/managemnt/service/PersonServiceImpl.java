package com.hr.managemnt.service;

import com.hr.managemnt.model.Persons;
import com.hr.managemnt.repository.CustomPersonRepository;
import com.hr.managemnt.repository.PersonRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private CustomPersonRepository customPersonRepository;

    @Autowired
    PersonRepository personRepository;

    public List<Persons> getAllPersons() {
        return personRepository.findAll();
    }

    public List<Persons> getPersonsAboveAge25() {
        return customPersonRepository.getPersonsAboveAge25();
    }


    @Override
    public List<Persons> getPersonsWithThreeTags() {
        return customPersonRepository.personsWithThreeTags();
    }

    @Override
    public List<Document> getGroupedByEyeColor() {
        return customPersonRepository.groupByEyeColor();
    }


    @Override
    public List<Document> getEyeColorBlue() {
        return customPersonRepository.matchEyeColorBlue();
    }


    @Override
    public List<Document> getActiveUsers() {
        return customPersonRepository.matchActiveUsers();
    }

    @Override
    public List<Document> getGroupedByAge() {
        return customPersonRepository.groupByAge();
    }

    @Override
    public List<Document> getUnwindTags() {
        return customPersonRepository.unwindTags();
    }

    @Override
    public List<Document> getUnwindTagsGrouped() {
        return customPersonRepository.unwindTagsThenGroup();
    }

    @Override
    public List<Document> getCompanyLocation() {
        return customPersonRepository.projectCompanyLocation();
    }


    @Override
    public List<Document> getTagsContainingConsequat() {
        return customPersonRepository.filterTagsContainingConsequat();
    }

    @Override
    public List<Document> groupByCompanyCountry() {
        return customPersonRepository.groupByCompanyCountry();
    }


    @Override
    public List<Document> groupByEyeColorFruitGender() {
        return customPersonRepository.groupByEyeColorFruitGender();
    }


    @Override
    public List<Document> groupEyeColorAgeAbove30() {
        return customPersonRepository.groupEyeColorAgeAbove30();
    }

    @Override
    public List<Document> countEyeColorAgeCombinations() {
        return customPersonRepository.countEyeColorAgeCombinations();
    }

    @Override
    public List<Document> groupAndSortNonBrownEyesFruit() {
        return customPersonRepository.groupAndSortNonBrownEyesFruit();
    }

    @Override
    public List<Document> projectCountryAndEmail() {
        return customPersonRepository.projectCountryAndEmail();
    }

    @Override
    public List<Document> unwindTagsWithFields() {
        return customPersonRepository.unwindTagsWithFields();
    }

    @Override
    public List<Document> groupByNameAndTags() {
        return customPersonRepository.groupByNameAndTags();
    }

    @Override
    public List<Document> groupByFavoriteFruitCount() {
        return customPersonRepository.groupByFavoriteFruitCount();
    }

    @Override
    public List<Document> groupByTagsSorted() {
        return customPersonRepository.groupByTagsSorted();
    }

    @Override
    public List<Document> avgAgeByEyeColor() {
        return customPersonRepository.avgAgeByEyeColor();
    }

}