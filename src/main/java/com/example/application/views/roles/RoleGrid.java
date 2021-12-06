package com.example.application.views.roles;

import java.util.Collection;
import java.util.List;

import com.example.application.data.entity.RoleEntity;
import com.vaadin.flow.component.grid.Grid;

public class RoleGrid extends Grid<RoleEntity> {
	private static final long serialVersionUID = 1L;
	private List<RoleEntity> roles;

	public RoleGrid(final List<RoleEntity> roles) {
		super(RoleEntity.class, false);
		this.roles = roles;
		init();
	}

	private void init() {
		this.setItems(roles);

		final Column<RoleEntity> codeColumn = addColumn(RoleEntity::getCode);
		codeColumn.setSortable(true);
		codeColumn.setHeader("Име");
		final Column<RoleEntity> descriptionColumn = addColumn(RoleEntity::getDescription);
		descriptionColumn.setSortable(true);
		descriptionColumn.setHeader("Описание");

	}

	public void setRoles(final Collection<RoleEntity> roles) {
		this.roles.clear();
		this.roles.addAll(roles);
		this.setItems(roles);
	}

}
