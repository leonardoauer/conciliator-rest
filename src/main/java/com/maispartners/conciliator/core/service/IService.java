package com.maispartners.conciliator.core.service;

import com.maispartners.conciliator.core.model.Bean;
import com.maispartners.conciliator.core.repository.jdbc.CrudFunctions;

public interface IService<T extends Bean> extends CrudFunctions<Long, T>{

}
