/*******************************************************************************
 *  Copyright (c) 2018, 2020 University of Southampton.
 *
 *  This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License 2.0
 *  which accompanies this distribution, and is available at
 *  https://www.eclipse.org/legal/epl-2.0/
 *
 *  SPDX-License-Identifier: EPL-2.0
 *
 *  Contributors:
 *    University of Southampton - initial API and implementation 
 *******************************************************************************/

package ac.soton.xeventb.common

import java.util.List
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.containers.StateBasedContainerManager

/** 
 * <p>
 * An implementation for StateBasedContainerManager, including a definition of visible containers
 * to include other projects in the workspace
 * </p>
 * @author Dana
 * @version 0.1
 * @since 0.0.7
 */
class EventBContainerManager extends StateBasedContainerManager {
	override protected List<IContainer> getVisibleContainers(List<String> handles,
		IResourceDescriptions resourceDescriptions) {
		var List<IContainer> result = super.getVisibleContainers(handles, resourceDescriptions)
		for (IResourceDescription rd : resourceDescriptions.getAllResourceDescriptions()) {
			var IContainer container = super.getContainer(rd, resourceDescriptions)
			if(!container.isEmpty()) result.add(container)
		}
		return result
	}
}
