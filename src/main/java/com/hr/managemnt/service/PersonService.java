package com.hr.managemnt.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class PersonService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Document> matchAgeGreaterThan25() {
        MatchOperation match = match(Criteria.where("age").gt(25));
        return mongoTemplate.aggregate(newAggregation(match), "persons", Document.class).getMappedResults();
    }

    public List<Document> matchAgeLessThanOrEqual30() {
        MatchOperation match = match(Criteria.where("age").lte(30));
        return mongoTemplate.aggregate(newAggregation(match), "persons", Document.class).getMappedResults();
    }

    public List<Document> matchEyeColorBlue() {
        MatchOperation match = match(Criteria.where("eyeColor").is("blue"));
        return mongoTemplate.aggregate(newAggregation(match), "persons", Document.class).getMappedResults();
    }

    public List<Document> matchActiveUsers() {
        MatchOperation match = match(Criteria.where("isActive").is(true));
        return mongoTemplate.aggregate(newAggregation(match), "persons", Document.class).getMappedResults();
    }

    public List<Document> groupByAge() {
        GroupOperation group = group("age").count().as("count");
        return mongoTemplate.aggregate(newAggregation(group), "persons", Document.class).getMappedResults();
    }

    public List<Document> groupByGender() {
        GroupOperation group = group("gender").count().as("count");
        return mongoTemplate.aggregate(newAggregation(group), "persons", Document.class).getMappedResults();
    }

    public List<Document> groupByEyeColor() {
        GroupOperation group = group("eyeColor").count().as("count");
        return mongoTemplate.aggregate(newAggregation(group), "persons", Document.class).getMappedResults();
    }

    public List<Document> groupByCompanyTitle() {
        GroupOperation group = group("company.title").count().as("count");
        return mongoTemplate.aggregate(newAggregation(group), "persons", Document.class).getMappedResults();
    }

    public List<Document> unwindTags() {
        UnwindOperation unwind = unwind("tags");
        return mongoTemplate.aggregate(newAggregation(unwind), "persons", Document.class).getMappedResults();
    }

    public List<Document> unwindTagsThenGroup() {
        UnwindOperation unwind = unwind("tags");
        GroupOperation group = group("tags").count().as("count");
        return mongoTemplate.aggregate(newAggregation(unwind, group), "persons", Document.class).getMappedResults();
    }



    public List<Document> projectNameAndAge() {
        ProjectionOperation project = project("name", "age");
        return mongoTemplate.aggregate(newAggregation(project), "persons", Document.class).getMappedResults();
    }

    public List<Document> projectCompanyLocation() {
        ProjectionOperation project = project().and("company.location").as("location");
        return mongoTemplate.aggregate(newAggregation(project), "persons", Document.class).getMappedResults();
    }

    public List<Document> filterTagsContainingConsequat() {
        MatchOperation match = match(Criteria.where("tags").in("consequat"));
        return mongoTemplate.aggregate(newAggregation(match), "persons", Document.class).getMappedResults();
    }

    public List<Document> ageBetween20And40() {
        MatchOperation match = match(Criteria.where("age").gte(20).lte(40));
        return mongoTemplate.aggregate(newAggregation(match), "persons", Document.class).getMappedResults();
    }

    public List<Document> matchCompanyCountryUSA() {
        MatchOperation match = match(Criteria.where("company.location.country").is("USA"));
        return mongoTemplate.aggregate(newAggregation(match), "persons", Document.class).getMappedResults();
    }

    public List<Document> groupByCountry() {
        GroupOperation group = group("company.location.country").count().as("count");
        return mongoTemplate.aggregate(newAggregation(group), "persons", Document.class).getMappedResults();
    }

}
