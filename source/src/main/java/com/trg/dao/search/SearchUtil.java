package com.trg.dao.search;

import static com.trg.dao.search.ISearch.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Utilities for working with searches {@link ISearch}, {@link IMutableSearch}.
 * 
 * @author dwolverton
 */
public class SearchUtil {
	// ---------- Add ----------

	public static void addFetch(IMutableSearch search, String property) {
		if (property == null || "".equals(property))
			return; // null properties do nothing, don't bother to add them.

		List<String> fetches = search.getFetches();
		if (fetches == null) {
			fetches = new ArrayList<String>();
			search.setFetches(fetches);
		}
		fetches.add(property);
	}

	public static void addField(IMutableSearch search, Field field) {
		List<Field> fields = search.getFields();
		if (fields == null) {
			fields = new ArrayList<Field>();
			search.setFields(fields);
		}
		fields.add(field);
	}

	/**
	 * If this field is used with <code>resultMode == RESULT_MAP</code>, the
	 * <code>property</code> will also be used as the key for this value in the
	 * map.
	 */
	public static void addField(IMutableSearch search, String property) {
		if (property == null || "".equals(property))
			return; // null properties do nothing, don't bother to add them.
		addField(search, new Field(property));
	}

	/**
	 * If this field is used with <code>resultMode == RESULT_MAP</code>, the
	 * <code>property</code> will also be used as the key for this value in the
	 * map.
	 */
	public static void addField(IMutableSearch search, String property, int operator) {
		if (property == null || "".equals(property))
			return; // null properties do nothing, don't bother to add them.
		addField(search, new Field(property, operator));
	}

	/**
	 * If this field is used with <code>resultMode == RESULT_MAP</code>, the
	 * <code>key</code> will be used as the key for this value in the map.
	 */
	public static void addField(IMutableSearch search, String property, int operator, String key) {
		if (property == null || "".equals(property) || key == null || "".equals(key))
			return; // null properties do nothing, don't bother to add them.
		addField(search, new Field(property, operator, key));
	}

	/**
	 * If this field is used with <code>resultMode == RESULT_MAP</code>, the
	 * <code>key</code> will be used as the key for this value in the map.
	 */
	public static void addField(IMutableSearch search, String property, String key) {
		if (property == null || "".equals(property) || key == null || "".equals(key))
			return; // null properties do nothing, don't bother to add them.
		addField(search, new Field(property, key));
	}

	public static void addFilter(IMutableSearch search, Filter filter) {
		List<Filter> filters = search.getFilters();
		if (filters == null) {
			filters = new ArrayList<Filter>();
			search.setFilters(filters);
		}
		filters.add(filter);
	}

	/**
	 * Add a filter that uses the ALL operator.
	 */
	public static void addFilterAll(IMutableSearch search, String property, Filter filter) {
		addFilter(search, Filter.all(property, filter));
	}
	
	/**
	 * Add a filter that uses the AND operator.
	 * 
	 * <p>
	 * This takes a variable number of parameters. Any number of <code>Filter
	 * </code>s can be
	 * specified.
	 */
	public static void addFilterAnd(IMutableSearch search, Filter... filters) {
		addFilter(search, Filter.and(filters));
	}

	/**
	 * Add a filter that uses the IS EMPTY operator.
	 */
	public static void addFilterEmpty(IMutableSearch search, String property) {
		addFilter(search, Filter.isEmpty(property));
	}
	
	/**
	 * Add a filter that uses the == operator.
	 */
	public static void addFilterEqual(IMutableSearch search, String property, Object value) {
		addFilter(search, Filter.equal(property, value));
	}

	/**
	 * Add a filter that uses the >= operator.
	 */
	public static void addFilterGreaterOrEqual(IMutableSearch search, String property, Object value) {
		addFilter(search, Filter.greaterOrEqual(property, value));
	}

	/**
	 * Add a filter that uses the > operator.
	 */
	public static void addFilterGreaterThan(IMutableSearch search, String property, Object value) {
		addFilter(search, Filter.greaterThan(property, value));
	}

	/**
	 * Add a filter that uses the ILIKE operator.
	 */
	public static void addFilterILike(IMutableSearch search, String property, String value) {
		addFilter(search, Filter.ilike(property, value));
	}

	/**
	 * Add a filter that uses the IN operator.
	 */
	public static void addFilterIn(IMutableSearch search, String property, Collection<?> value) {
		addFilter(search, Filter.in(property, value));
	}

	/**
	 * Add a filter that uses the IN operator.
	 * 
	 * <p>
	 * This takes a variable number of parameters. Any number of values can be
	 * specified.
	 */
	public static void addFilterIn(IMutableSearch search, String property, Object... value) {
		addFilter(search, Filter.in(property, value));
	}

	/**
	 * Add a filter that uses the <= operator.
	 */
	public static void addFilterLessOrEqual(IMutableSearch search, String property, Object value) {
		addFilter(search, Filter.lessOrEqual(property, value));
	}

	/**
	 * Add a filter that uses the < operator.
	 */
	public static void addFilterLessThan(IMutableSearch search, String property, Object value) {
		addFilter(search, Filter.lessThan(property, value));
	}

	/**
	 * Add a filter that uses the LIKE operator.
	 */
	public static void addFilterLike(IMutableSearch search, String property, String value) {
		addFilter(search, Filter.like(property, value));
	}

	/**
	 * Add a filter that uses the NONE operator.
	 */
	public static void addFilterNone(IMutableSearch search, String property, Filter filter) {
		addFilter(search, Filter.none(property, filter));
	}

	/**
	 * Add a filter that uses the NOT operator.
	 */
	public static void addFilterNot(IMutableSearch search, Filter filter) {
		addFilter(search, Filter.not(filter));
	}

	/**
	 * Add a filter that uses the != operator.
	 */
	public static void addFilterNotEqual(IMutableSearch search, String property, Object value) {
		addFilter(search, Filter.notEqual(property, value));
	}

	/**
	 * Add a filter that uses the NOT IN operator.
	 */
	public static void addFilterNotIn(IMutableSearch search, String property, Collection<?> value) {
		addFilter(search, Filter.notIn(property, value));
	}

	/**
	 * Add a filter that uses the NOT IN operator.
	 * 
	 * <p>
	 * This takes a variable number of parameters. Any number of values can be
	 * specified.
	 */
	public static void addFilterNotIn(IMutableSearch search, String property, Object... value) {
		addFilter(search, Filter.notIn(property, value));
	}

	/**
	 * Add a filter that uses the IS NOT EMPTY operator.
	 */
	public static void addFilterNotEmpty(IMutableSearch search, String property) {
		addFilter(search, Filter.isNotEmpty(property));
	}
	
	/**
	 * Add a filter that uses the IS NOT NULL operator.
	 */
	public static void addFilterNotNull(IMutableSearch search, String property) {
		addFilter(search, Filter.isNotNull(property));
	}

	/**
	 * Add a filter that uses the IS NULL operator.
	 */
	public static void addFilterNull(IMutableSearch search, String property) {
		addFilter(search, Filter.isNull(property));
	}

	/**
	 * Add a filter that uses the OR operator.
	 * 
	 * <p>
	 * This takes a variable number of parameters. Any number of <code>Filter
	 * </code>s can be
	 * specified.
	 */
	public static void addFilterOr(IMutableSearch search, Filter... filters) {
		addFilter(search, Filter.or(filters));
	}

	/**
	 * Add a filter that uses the SOME operator.
	 */
	public static void addFilterSome(IMutableSearch search, String property, Filter filter) {
		addFilter(search, Filter.some(property, filter));
	}
	
	// Sorts
	public static void addSort(IMutableSearch search, Sort sort) {
		if (sort == null)
			return;

		List<Sort> sorts = search.getSorts();
		if (sorts == null) {
			sorts = new ArrayList<Sort>();
			search.setSorts(sorts);
		}
		sorts.add(sort);
	}

	/**
	 * Add sort by property. Ascending if <code>desc == false</code>, descending
	 * if <code>desc == true</code>.
	 */
	public static void addSort(IMutableSearch search, String property, boolean desc) {
		addSort(search, property, desc, false);
	}

	/**
	 * Add sort by property. Ascending if <code>desc == false</code>, descending
	 * if <code>desc == true</code>.
	 */
	public static void addSort(IMutableSearch search, String property, boolean desc, boolean ignoreCase) {
		if (property == null)
			return; // null properties do nothing, don't bother to add them.
		addSort(search, new Sort(property, desc, ignoreCase));
	}

	/**
	 * Add ascending sort by property
	 */
	public static void addSortAsc(IMutableSearch search, String property) {
		addSort(search, property, false, false);
	}

	/**
	 * Add ascending sort by property
	 */
	public static void addSortAsc(IMutableSearch search, String property, boolean ignoreCase) {
		addSort(search, property, false, ignoreCase);
	}

	/**
	 * Add descending sort by property
	 */
	public static void addSortDesc(IMutableSearch search, String property) {
		addSort(search, property, true, false);
	}

	/**
	 * Add descending sort by property
	 */
	public static void addSortDesc(IMutableSearch search, String property, boolean ignoreCase) {
		addSort(search, property, true, ignoreCase);
	}

	// ---------- Remove ----------

	public static void removeFetch(IMutableSearch search, String property) {
		if (search.getFetches() != null)
			search.getFetches().remove(property);
	}

	public static void removeField(IMutableSearch search, Field field) {
		if (search.getFields() != null)
			search.getFields().remove(field);
	}

	public static void removeField(IMutableSearch search, String property) {
		if (search.getFields() == null)
			return;

		Iterator<Field> itr = search.getFields().iterator();
		while (itr.hasNext()) {
			if (itr.next().getProperty().equals(property))
				itr.remove();
		}
	}

	public static void removeField(IMutableSearch search, String property, String key) {
		if (search.getFields() == null)
			return;

		Iterator<Field> itr = search.getFields().iterator();
		while (itr.hasNext()) {
			Field field = itr.next();
			if (field.getProperty().equals(property) && field.getKey().equals(key))
				itr.remove();
		}
	}

	public static void removeFilter(IMutableSearch search, Filter filter) {
		List<Filter> filters = search.getFilters();
		if (filters != null)
			filters.remove(filter);
	}

	/**
	 * Remove all filters on the given property.
	 */
	public static void removeFiltersOnProperty(IMutableSearch search, String property) {
		if (property == null || search.getFilters() == null)
			return;
		Iterator<Filter> itr = search.getFilters().iterator();
		while (itr.hasNext()) {
			if (property.equals(itr.next().getProperty()))
				itr.remove();
		}
	}

	public static void removeSort(IMutableSearch search, Sort sort) {
		if (search.getSorts() != null)
			search.getSorts().remove(sort);
	}

	public static void removeSort(IMutableSearch search, String property) {
		if (property == null || search.getSorts() == null)
			return;
		Iterator<Sort> itr = search.getSorts().iterator();
		while (itr.hasNext()) {
			if (property.equals(itr.next().getProperty()))
				itr.remove();
		}
	}

	// ---------- Clear ----------

	public static void clear(IMutableSearch search) {
		clearFilters(search);
		clearSorts(search);
		clearFields(search);
		clearPaging(search);
		clearFetches(search);
		search.setResultMode(RESULT_AUTO);
		search.setDisjunction(false);
	}

	public static void clearFetches(IMutableSearch search) {
		if (search.getFetches() != null)
			search.getFetches().clear();
	}

	public static void clearFields(IMutableSearch search) {
		if (search.getFields() != null)
			search.getFields().clear();
	}

	public static void clearFilters(IMutableSearch search) {
		if (search.getFilters() != null)
			search.getFilters().clear();
	}

	public static void clearPaging(IMutableSearch search) {
		search.setFirstResult(-1);
		search.setPage(-1);
		search.setMaxResults(-1);
	}

	public static void clearSorts(IMutableSearch search) {
		if (search.getSorts() != null)
			search.getSorts().clear();
	}
	
	// ---------- Merge ----------
	/**
	 * Modify the search by adding the given sorts before the current sorts in the search.
	 */
	public static void mergeSortsBefore(IMutableSearch search, List<Sort> sorts) {
		List<Sort> list = search.getSorts();
		if (list == null) {
			list = new ArrayList<Sort>();
			search.setSorts(list);
		}
		
		if (list.size() > 0) {
			//remove any sorts from the search that already sort on the same property as one of the new sorts
			Iterator<Sort> itr = list.iterator();
			while (itr.hasNext()) {
				String property = itr.next().getProperty();
				if (property == null) {
					itr.remove();
				} else {
					for (Sort sort : sorts) {
						if (property.equals(sort.getProperty())) {
							itr.remove();
							break;
						}
					}
				}
			}
		}
		
		list.addAll(0, sorts);
	}
	
	/**
	 * Modify the search by adding the given sorts before the current sorts in the search.
	 */
	public static void mergeSortsBefore(IMutableSearch search, Sort... sorts) {
		mergeSortsBefore(search, Arrays.asList(sorts));
	}
	
	/**
	 * Modify the search by adding the given sorts after the current sorts in the search.
	 */
	public static void mergeSortsAfter(IMutableSearch search, List<Sort> sorts) {
		List<Sort> list = search.getSorts();
		if (list == null) {
			list = new ArrayList<Sort>();
			search.setSorts(list);
		}
		
		int origLen = list.size();
		
		if (origLen > 0) {
			//don't add sorts that are already in the list
			for (Sort sort : sorts) {
				if (sort.getProperty() != null) {
					boolean found = false;
					for (int i = 0; i < origLen; i++) {
						if (sort.getProperty().equals(list.get(i).getProperty())) {
							found = true;
							break;
						}
					}
					if (!found)
						list.add(sort);
				}
			}
		} else {
			list.addAll(sorts);
		}
	}
	
	/**
	 * Modify the search by adding the given sorts after the current sorts in the search.
	 */
	public static void mergeSortsAfter(IMutableSearch search, Sort... sorts) {
		mergeSortsAfter(search, Arrays.asList(sorts));
	}
	
	/**
	 * Modify the search by adding the given fetches to the current fetches in the search.
	 */
	public static void mergeFetches(IMutableSearch search, List<String> fetches) {
		List<String> list = search.getFetches();
		if (list == null) {
			list = new ArrayList<String>();
			search.setFetches(list);
		}
		
		for (String fetch : fetches) {
			if (!list.contains(fetch)) {
				list.add(fetch);
			}
		}
	}
	
	/**
	 * Modify the search by adding the given fetches to the current fetches in the search.
	 */
	public static void mergeFetches(IMutableSearch search, String... fetches) {
		mergeFetches(search, Arrays.asList(fetches));
	}
	
	/**
	 * Modify the search by adding the given filters using AND semantics
	 */
	public static void mergeFiltersAnd(IMutableSearch search, List<Filter> filters) {
		List<Filter> list = search.getFilters();
		if (list == null) {
			list = new ArrayList<Filter>();
			search.setFilters(list);
		}
		
		if (list.size() == 0 || !search.isDisjunction()) {
			search.setDisjunction(false);
			list.addAll(filters);
		} else {
			search.setFilters(new ArrayList<Filter>());
			
			//add the previous filters with an OR
			Filter orFilter = Filter.or();
			orFilter.setValue(list);
			addFilter(search, orFilter);
			
			//add the new filters with AND
			search.setDisjunction(false);
			search.getFilters().addAll(filters);
		}
	}
	
	/**
	 * Modify the search by adding the given filters using AND semantics
	 */
	public static void mergeFiltersAnd(IMutableSearch search, Filter... filters) {
		mergeFiltersAnd(search, Arrays.asList(filters));
	}
	
	/**
	 * Modify the search by adding the given filters using OR semantics
	 */
	public static void mergeFiltersOr(IMutableSearch search, List<Filter> filters) {
		List<Filter> list = search.getFilters();
		if (list == null) {
			list = new ArrayList<Filter>();
			search.setFilters(list);
		}
		
		if (list.size() == 0 || search.isDisjunction()) {
			search.setDisjunction(true);
			list.addAll(filters);
		} else {
			search.setFilters(new ArrayList<Filter>());
			
			//add the previous filters with an AND
			Filter orFilter = Filter.and();
			orFilter.setValue(list);
			addFilter(search, orFilter);
			
			//add the new filters with or
			search.setDisjunction(true);
			search.getFilters().addAll(filters);
		}
	}
	
	/**
	 * Modify the search by adding the given filters using OR semantics
	 */
	public static void mergeFiltersOr(IMutableSearch search, Filter... filters) {
		mergeFiltersOr(search, Arrays.asList(filters));
	}
	
	/**
	 * Modify the search by adding the given fields before the current fields in the search.
	 */
	public static void mergeFieldsBefore(IMutableSearch search, List<Field> fields) {
		List<Field> list = search.getFields();
		if (list == null) {
			list = new ArrayList<Field>();
			search.setFields(list);
		}
		
		list.addAll(0, fields);
	}
	
	/**
	 * Modify the search by adding the given fields before the current fields in the search.
	 */
	public static void mergeFieldsBefore(IMutableSearch search, Field... fields) {
		mergeFieldsBefore(search, Arrays.asList(fields));
	}
	
	/**
	 * Modify the search by adding the given fields after the current fields in the search.
	 */
	public static void mergeFieldsAfter(IMutableSearch search, List<Field> fields) {
		List<Field> list = search.getFields();
		if (list == null) {
			list = new ArrayList<Field>();
			search.setFields(list);
		}
		
		list.addAll(fields);
	}
	
	/**
	 * Modify the search by adding the given fields after the current fields in the search.
	 */
	public static void mergeFieldsAfter(IMutableSearch search, Field... fields) {
		mergeFieldsAfter(search, Arrays.asList(fields));
	}
	
	
	// ---------- Other Methods ----------

	/**
	 * Calculate the first result to use given the <code>firstResult</code>,
	 * <code>page</code> and <code>maxResults</code> values of the search
	 * object.
	 * 
	 * <p>
	 * The calculation is as follows:
	 * <ul>
	 * <li>If <code>firstResult</code> is defined (i.e. > 0), use it.
	 * <li>Otherwise if <code>page</code> and <code>maxResults</code> are
	 * defined (i.e. > 0), use <code>page * maxResults</code>.
	 * <li>Otherwise, just use 0.
	 * </ul>
	 */
	public static int calcFirstResult(ISearch search) {
		return (search.getFirstResult() > 0) ? search.getFirstResult() : (search.getPage() > 0 && search
				.getMaxResults() > 0) ? search.getPage() * search.getMaxResults() : 0;
	}

	/**
	 * Copy the contents of the source search object to the destination search
	 * object, overriding any contents previously found in the destination. All
	 * collections are copied into new collections, but them items in those
	 * collections are not duplicated; they still point to the same objects.
	 */
	public static void copy(ISearch source, IMutableSearch destination) {
		destination.setSearchClass(source.getSearchClass());
		destination.setDisjunction(source.isDisjunction());
		destination.setResultMode(source.getResultMode());
		destination.setFirstResult(source.getFirstResult());
		destination.setPage(source.getPage());
		destination.setMaxResults(source.getMaxResults());
		destination.setFilters(new ArrayList<Filter>());

		ArrayList<String> fetches = new ArrayList<String>();
		fetches.addAll(source.getFetches());
		destination.setFetches(fetches);

		ArrayList<Field> fields = new ArrayList<Field>();
		fields.addAll(source.getFields());
		destination.setFields(fields);

		ArrayList<Filter> filters = new ArrayList<Filter>();
		filters.addAll(source.getFilters());
		destination.setFilters(filters);

		ArrayList<Sort> sorts = new ArrayList<Sort>();
		sorts.addAll(source.getSorts());
		destination.setSorts(sorts);
	}

	/**
	 * Return true if the search objects have equivalent contents.
	 */
	public static boolean equals(ISearch search, Object obj) {
		if (search == obj)
			return true;
		if (!(obj instanceof ISearch))
			return false;
		ISearch s = (ISearch) obj;

		if (search.getSearchClass() == null ? s.getSearchClass() != null : !search.getSearchClass().equals(
				s.getSearchClass()))
			return false;
		if (search.isDisjunction() != s.isDisjunction() || search.getResultMode() != s.getResultMode()
				|| search.getFirstResult() != s.getFirstResult() || search.getPage() != s.getPage()
				|| search.getMaxResults() != s.getMaxResults())
			return false;

		if (search.getFetches() == null ? s.getFetches() != null : !search.getFetches().equals(s.getFetches()))
			return false;
		if (search.getFields() == null ? s.getFields() != null : !search.getFields().equals(s.getFields()))
			return false;
		if (search.getFilters() == null ? s.getFilters() != null : !search.getFilters().equals(s.getFilters()))
			return false;
		if (search.getSorts() == null ? s.getSorts() != null : !search.getSorts().equals(s.getSorts()))
			return false;

		return true;
	}

	/**
	 * Return a hash code value for the given search.
	 */
	public static int hashCode(ISearch search) {
		int hash = 1;
		hash = hash * 31 + (search.getSearchClass() == null ? 0 : search.getSearchClass().hashCode());
		hash = hash * 31 + (search.getFields() == null ? 0 : search.getFields().hashCode());
		hash = hash * 31 + (search.getFilters() == null ? 0 : search.getFilters().hashCode());
		hash = hash * 31 + (search.getSorts() == null ? 0 : search.getSorts().hashCode());
		hash = hash * 31 + (search.isDisjunction() ? 1 : 0);
		hash = hash * 31 + (new Integer(search.getResultMode()).hashCode());
		hash = hash * 31 + (new Integer(search.getFirstResult()).hashCode());
		hash = hash * 31 + (new Integer(search.getPage()).hashCode());
		hash = hash * 31 + (new Integer(search.getMaxResults()).hashCode());

		return hash;
	}

	/**
	 * Return a human-readable string describing the contents of the given
	 * search.
	 */
	public static String toString(ISearch search) {
		StringBuilder sb = new StringBuilder("Search(");
		sb.append(search.getSearchClass());
		sb.append(")[first: ").append(search.getFirstResult());
		sb.append(", page: ").append(search.getPage());
		sb.append(", max: ").append(search.getMaxResults());
		sb.append("] {\n resultMode: ");

		switch (search.getResultMode()) {
		case RESULT_AUTO:
			sb.append("AUTO");
			break;
		case RESULT_ARRAY:
			sb.append("ARRAY");
			break;
		case RESULT_LIST:
			sb.append("LIST");
			break;
		case RESULT_MAP:
			sb.append("MAP");
			break;
		case RESULT_SINGLE:
			sb.append("SINGLE");
			break;
		default:
			sb.append("**INVALID RESULT MODE: (" + search.getResultMode() + ")**");
			break;
		}

		sb.append(",\n disjunction: ").append(search.isDisjunction());
		sb.append(",\n fields: { ");
		appendList(sb, search.getFields(), ", ");
		sb.append(" },\n filters: {\n  ");
		appendList(sb, search.getFilters(), ",\n  ");
		sb.append("\n },\n sorts: { ");
		appendList(sb, search.getSorts(), ", ");
		sb.append(" }\n}");

		return sb.toString();
	}

	private static void appendList(StringBuilder sb, List<?> list, String separator) {
		if (list == null) {
			sb.append("null");
			return;
		}

		boolean first = true;
		for (Object o : list) {
			if (first) {
				first = false;
			} else {
				sb.append(separator);
			}
			sb.append(o);
		}
	}
}
