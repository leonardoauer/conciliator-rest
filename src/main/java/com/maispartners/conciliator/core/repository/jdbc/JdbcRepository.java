package com.maispartners.conciliator.core.repository.jdbc;

import com.maispartners.conciliator.core.model.Bean;

public interface JdbcRepository<T extends Bean> extends CrudFunctions<Long, T> {

}
