package org.kdp.learn_vocabulary_kdp.model.dto.paging;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
public class PageableDto {
    List<Object> content;
    int pageNo;
    int pageSize;
    long totalElements;
    int totalPages;
    boolean sorted;
    boolean first;
    boolean last;
    boolean empty;

    public <T> PageableDto(Page<T> page) {
        Pageable pageable = page.getPageable();

        setPageNo(pageable.getPageNumber());
        setPageSize(pageable.getPageSize());
        setTotalElements(page.getTotalElements());
        setTotalPages(page.getTotalPages());
        setSorted(pageable.getSort().isSorted());
        setFirst(page.isFirst());
        setLast(page.isLast());
        setEmpty(page.isEmpty());
    }
}

