
package com.linkedin.api.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import com.linkedin.api.resource.support.ResponseWrapper;


/**
 * Describes field selectors uri path parameter
 * 
 * 
 */
@Path("job-search{fieldSelectors}")
public interface JobSearchAPIResource {


    /**
     * Returns Jobs found by some criteria
     * 
     * 
     * @param facet
     *     Facet values to search over.
     *     
     * @param distance
     *     Matches jobs within a distance from a central point. This is measured in miles. This is best used in combination with both country-code and postal-code.
     * @param sort
     *     "Controls the search result order. There are four options:
     *     connections: Number of connections per person, from largest to smallest.
     *     recommenders: Number of recommendations per person, from largest to smallest.
     *     distance: Degree of separation within the member's network, from first degree, then second degree, and then all others mixed together, including third degree and out-of-network.
     *     relevance: Relevance of results based on the query, from most to least relevant.          
     *     By default, results are ordered by the number of connections."
     *     
     * @param keywords
     *     Members who have all the keywords anywhere in their profile. Use this field when you don't know how to
     *     more accurately map the input to a more specific parameter. (Don't forget to URL encode this data.)
     *     
     * @param postalCode
     *     Matches jobs centered around a Postal Code. Must be combined with the country-code parameter. Not supported for all countries.
     * @param count
     *     Maximum e.g. count=10
     * @param start
     *     The offset by which to start Network Update pagination e.g. start=0
     * @param facets
     *     |Parameter| Definition| Values|
     *     |---|---|---|
     *     |company|The job postings by company.|| 
     *     |date-posted|The job postings by the date posted.|Format: YearMonthDay (e.g. 20121031)|
     *     |location|A geographical region. This is not necessarily a country. It could be a city or regional area, such as San Francisco Bay Area.|A geographical code, such as us:84 for San Francisco Bay Area or fr:0 for France.|
     *     |job-function|The job postings by job function.|| 
     *     |industry|An industry field.|Industry values are listed on a separate page.|
     *     |salary|The job postings based on salary.||
     *     
     * @param fieldSelectors
     *     Many of our resources allow you to specify what fields you want returned. We call this syntax field selectors.
     *     By indicating exactly the information you need, we can optimize the amount of time needed to return your results.
     *     It also reduces the amount of data passing across the wire. The two combine to make our APIs speedy and efficient,
     *     a critical factor in any web application, and more so for anyone relying on external APIs.
     *     
     *     Field selectors are specified after the resource identifiers and path components of a resource, prefixed by a colon,
     *     contained within parenthesis, and separated by commas. Fields will be returned in the order specified. When URL-encoding
     *     your resource URLs, ensure that the parenthesis used in selectors remain unescaped.
     *     
     *     Examples
     *     --------
     *     To get a member's ID, first name, last name, and industry:
     *       `http://api.linkedin.com/v1/people/~:(id,first-name,last-name,industry)`
     *     
     *     Or the same set of information for their connections:
     *       `http://api.linkedin.com/v1/people/~/connections:(id,first-name,last-name,industry)`
     *     
     *     Fields selectors can also be nested to access individual fields from a larger collection. For example, to get just the
     *     job titles and not the rest of the information about positions:
     *       `http://api.linkedin.com/v1/people/~/connections:(id,first-name,last-name,positions:(title))`
     *     
     *     Field selectors with resource identifiers allow you to request information about multiple entities at once. Specify them
     *     similarly, but append a double colon - here's an example getting profile information about thee members: the first is the
     *     current member, indicated by a tilde; the next has an id of 12345; and the last has a public profile URL
     *     
     *       `http://api.linkedin.com/v1/people::(~, id=12345,url=http%3A%2F%2Fwww.linkedin.com%2Fin%2Fadamnash)`
     *      e.g. :(id,first-name,last-name,industry)
     * @param countryCode
     *     Matches jobs with a location in a specific country. Values are defined in by ISO 3166 standard. Country codes must be in all lower case.
     * @param companyName
     *     Jobs with a matching company name. It's often valuable to not be too specific with the company name. LinkedIn has made great efforts at standardizing company names, but including suffixes such as "Inc" and "Company" may overly limit your search, missing people who did not include those suffixes on their company names. It's usually better to  search for the basic name of the company and all different versions will be returned. This does increase the possibility of a false positive match return, though, so consider the most specific terms you can use. For example, consider using "Acme" instead of "Acme, Inc" to find people from a company called Acme, Inc. But this runs the risk of finding people from different companies with Acme in the title, such as "Acme Vending" and "Acme Services".
     *      e.g. Acme Vending
     * @param jobTitle
     *     Matches jobs with the same job title.
     */
    @GET
    @Produces({
        "application/xml",
        "application/json"
    })
    JobSearchAPIResource.GetJobSearchByFieldSelectorsResponse getJobSearchByFieldSelectors(
        @PathParam("fieldSelectors")
        String fieldSelectors,
        @QueryParam("distance")
        String distance,
        @QueryParam("postal-code")
        String postalCode,
        @QueryParam("country-code")
        String countryCode,
        @QueryParam("job-title")
        String jobTitle,
        @QueryParam("company-name")
        String companyName,
        @QueryParam("count")
        @DefaultValue("10")
        int count,
        @QueryParam("start")
        String start,
        @QueryParam("keywords")
        String keywords,
        @QueryParam("facet")
        String facet,
        @QueryParam("facets")
        String facets,
        @QueryParam("sort")
        @DefaultValue("connections")
        JobSearchAPIResource.Sort sort)
        throws Exception
    ;

    public class GetJobSearchByFieldSelectorsResponse
        extends ResponseWrapper
    {


        private GetJobSearchByFieldSelectorsResponse(Response delegate) {
            super(delegate);
        }

        /**
         * 
         * @param entity
         *     
         */
        public static JobSearchAPIResource.GetJobSearchByFieldSelectorsResponse withJsonOK(StreamingOutput entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
            responseBuilder.entity(entity);
            return new JobSearchAPIResource.GetJobSearchByFieldSelectorsResponse(responseBuilder.build());
        }

        /**
         * 
         * @param entity
         *     
         */
        public static JobSearchAPIResource.GetJobSearchByFieldSelectorsResponse withXmlOK(StreamingOutput entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/xml");
            responseBuilder.entity(entity);
            return new JobSearchAPIResource.GetJobSearchByFieldSelectorsResponse(responseBuilder.build());
        }

    }

    public enum Sort {

        connections,
        recommenders,
        distance,
        relevance;

    }

}
