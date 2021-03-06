/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.deployer.admin.completion;

import java.util.List;

import org.springframework.boot.configurationmetadata.ConfigurationMetadataProperty;

/**
 * Various utility methods used throughout the completion package.
 *
 * @author Eric Bottard
 * @author Mark Fisher
 */
public class CompletionUtils {

	/**
	 * Return whether the given property name should be considered matching the candidate configuration property, also
	 * taking into account the list of whitelist properties (which are tested on their short name).
	 */
	static boolean isMatchingProperty(String propertyName, ConfigurationMetadataProperty property, List<ConfigurationMetadataProperty> whiteListedProps) {
		if (property.getId().equals(propertyName)) {
			return true; // For any prop
		} // Handle special case of short form for whitelist
		else {
			for (ConfigurationMetadataProperty white : whiteListedProps) {
				if (property.getId().equals(white.getId())) { // prop#equals() not implemented
					return property.getName().equals(propertyName);
				}
			}
			return false;
		}
	}
}
