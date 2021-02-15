package br.com.limpacity.api.controller.base;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseBodyDTO<T> implements Serializable {

    private static final long serialVersionUID = 1388706364317434472L;

    protected MetaDTO meta;
    protected List<ErrorDTO> errors;
    protected List<T> records;

    public ResponseBodyDTO()
    {

    }

    public ResponseBodyDTO(List<ErrorDTO> errors )
    {
        this.meta = null;
        this.errors = errors;
    }

    public ResponseBodyDTO(ErrorDTO error )
    {
        this.meta = null;
        this.errors = new ArrayList<>();
        this.errors.add(error);
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }
    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }

    public void addError(ErrorDTO error)
    {
        if (errors==null) {
            errors = new ArrayList<>();
        }

        errors.add(error);

    }

    public void addErrors(List<ErrorDTO> errors) {
        if((this.errors == null) || this.errors.isEmpty()) {
            this.errors = errors;
        } else {
            errors.forEach(error -> {
                this.errors.add(error);
            });
        }
    }

    public void setMeta(MetaDTO meta)
    {
        this.meta = meta;
    }

    public MetaDTO getMeta() {

        if (meta ==null)
        {
            String hostName = "";
            try {
                hostName = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                hostName = "UnknownHost";
            }

            return MetaDTO.builder()
                    .server(hostName)
                    .limit(this.records==null ? 0: this.records.size())
                    .offset(0L)
                    .recordCount(this.records==null ? 0: this.records.size())
                    .build();
        }
        else
        {
            return meta;
        }
    }

    public boolean isSucess()
    {
        if ((errors==null) || errors.isEmpty()) {
            return true;
        }

        return false;
    }

    public boolean isFailure() {
        return errors != null && !errors.isEmpty();
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public void addRecord(T record)
    {
        if (this.records==null) {
            records = new ArrayList<>();
        }

        records.add(record);

    }

    public static <T,R> ResponseBodyDTO<?> of(List<R> list, Long offSet, Integer size,
                                              Integer totalPages, Long totalElements, Integer numberOfElements) {
        ResponseBodyDTO<R> response = new ResponseBodyDTO<>();
        addMetaOnResponse(response, offSet, size, totalPages, totalElements, numberOfElements);
        response.setRecords(list);
        return response;
    }

    public static <T> ResponseBodyDTO<T> of(List<T> list) {
        ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.getMeta().setRecordCount(list.size());
        list.forEach(response::addRecord);
        return response;
    }

    public static <T> ResponseBodyDTO<T> of(T t) {
        ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.getMeta().setRecordCount(1);
        response.addRecord(t);
        return response;
    }

    public static ResponseBodyDTO<ErrorDTO> with(ErrorDTO error) {
        ResponseBodyDTO<ErrorDTO> response = new ResponseBodyDTO<>();
        response.addError(error);
        return response;
    }

    public static ResponseBodyDTO<ErrorDTO> with(List<ErrorDTO> errors) {
        ResponseBodyDTO<ErrorDTO> response = new ResponseBodyDTO<>();
        response.setErrors(errors);
        return response;
    }

    public static  <T> ResponseBodyDTO<T> with(T t, ErrorDTO error) {
        ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.addRecord(t);
        response.addError(error);
        return response;
    }

    public static  <T> ResponseBodyDTO<T> with(List<T> list, ErrorDTO error) {
        ResponseBodyDTO<T> response = new ResponseBodyDTO<>();
        response.setRecords(list);
        response.addError(error);
        return response;
    }

    private static void addMetaOnResponse(ResponseBodyDTO<?> response, Long offSet, Integer size,
                                          Integer totalPages, Long totalElements, Integer numberOfElements) {
        response.setMeta(response.getMeta());
        response.getMeta().setOffset(offSet);
        response.getMeta().setLimit(size);
        response.getMeta().setTotalPages(totalPages);
        response.getMeta().setRecordCountTotal(totalElements);
        response.getMeta().setRecordCount(numberOfElements);
    }
}