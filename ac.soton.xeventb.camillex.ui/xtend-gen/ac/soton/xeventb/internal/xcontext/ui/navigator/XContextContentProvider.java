/**
 * Copyright (c) 2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     University of Southampton - initial API and implementation
 */
package ac.soton.xeventb.internal.xcontext.ui.navigator;

import ac.soton.xeventb.internal.xcontext.ui.navigator.XContextNavigatorObject;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * Specific sub-class for XMachine content provider.
 * 
 * @author dd4g12
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("all")
public final class XContextContentProvider implements /* AbstractXEventBContentProvider */ITreeContentProvider {
  /**
   * Returns the file extension, i.e., "bucx" for XContext files.
   * 
   * @return the file extension for XContext files.
   */
  @Override
  public String getFileExtension() {
    return "bucx";
  }
  
  /**
   * Returns the specific XContext navigator object constructed from
   * the corresponding resource.
   * 
   * @param resource
   *          The input resource corresponding to the XMachine.
   * @return the specific XMachine navigator object corresponding to
   *          the input resource.
   */
  @Override
  public XContextNavigatorObject getNavigatorObject(final IFile resource) {
    return new XContextNavigatorObject(resource);
  }
}
