package com.shg.bmapi.models.planner;

import java.util.Objects;
import java.util.Set;

public class NodeTaskCollectionDTO {
//    {
//        "totalElements": 12345,
//            "pageNumber": 12345,
//            "offset": 12345,
//            "limit": 12345,
//            "numberOfElements": 12345,
//            "content": [
//                {},
//                {}
//            ],
//            "sort":
//            {
//                "sorted": true,
//                "unsorted": true
//            }
//    }
    private Long totalElements;
    private Long pageNumber;
    private Long offset;
    private Long limit;
    private Long numberOfElements;
    private Set<TaskDTO> content;
    private Sort sort;

    public NodeTaskCollectionDTO() {

    }

    public NodeTaskCollectionDTO(Long totalElements, Long pageNumber, Long offset, Long limit, Long numberOfElements, Set<TaskDTO> content, Sort sort) {
        this.totalElements = totalElements;
        this.pageNumber = pageNumber;
        this.offset = offset;
        this.limit = limit;
        this.numberOfElements = numberOfElements;
        this.content = content;
        this.sort = sort;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public Long getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Long numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public Set<TaskDTO> getContent() {
        return content;
    }

    public void setContent(Set<TaskDTO> content) {
        this.content = content;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeTaskCollectionDTO that = (NodeTaskCollectionDTO) o;
        return Objects.equals(totalElements, that.totalElements) && Objects.equals(pageNumber, that.pageNumber) && Objects.equals(offset, that.offset) && Objects.equals(limit, that.limit) && Objects.equals(numberOfElements, that.numberOfElements) && Objects.equals(content, that.content) && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalElements, pageNumber, offset, limit, numberOfElements, content, sort);
    }

    @Override
    public String toString() {
        return "NodeTasksDTO{" +
                "totalElements=" + totalElements +
                ", pageNumber=" + pageNumber +
                ", offset=" + offset +
                ", limit=" + limit +
                ", numberOfElements=" + numberOfElements +
                ", content=" + content +
                ", sort=" + sort +
                '}';
    }
}
